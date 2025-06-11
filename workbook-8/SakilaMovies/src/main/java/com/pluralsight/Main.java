package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {

    /* ---------- 1. configure one pooled DataSource ---------- */
    private static BasicDataSource buildDataSource(String user, String pass) {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/sakila");
        ds.setUsername(user);
        ds.setPassword(pass);
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setInitialSize(3);        // optional tuning
        ds.setMaxTotal(10);
        return ds;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java -jar SakilaMovies.jar <dbUser> <dbPass>");
            System.exit(1);
        }

        BasicDataSource dataSource = buildDataSource(args[0], args[1]);
        Scanner scanner = new Scanner(System.in);

        /* ---------- 2. ask for a LAST name and list all matching actors ---------- */
        System.out.print("Enter an ACTOR'S LAST name to search: ");
        String last = scanner.nextLine().trim();

        listActorsByLastName(dataSource, last);

        /* ---------- 3. ask for the exact actor to show their films ---------- */
        System.out.print("\nEnter that actor's FIRST name: ");
        String first = scanner.nextLine().trim();
        System.out.print("Enter that actor's LAST name again: ");
        last = scanner.nextLine().trim();

        listFilmsForActor(dataSource, first, last);
    }

    /* ---------- helper #1: list actors by last name ---------- */
    private static void listActorsByLastName(BasicDataSource ds, String last) {
        String sql = """
                SELECT actor_id, first_name, last_name
                FROM   actor
                WHERE  last_name = ?
                ORDER  BY first_name
                """;

        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, last);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.isBeforeFirst()) {                 // 0 rows
                    System.out.println("⚠️  No actors found with that last name.");
                    return;
                }

                System.out.printf("%nActors with last name '%s':%n", last);
                System.out.printf("%-5s %-15s %-15s%n", "ID", "First", "Last");
                System.out.println("=".repeat(40));

                while (rs.next()) {
                    System.out.printf("%-5d %-15s %-15s%n",
                            rs.getInt("actor_id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"));
                }
            }
        } catch (Exception ex) {
            System.out.println("DB error listing actors: " + ex.getMessage());
        }
    }

    /* ---------- helper #2: list films for a specific actor ---------- */
    private static void listFilmsForActor(BasicDataSource ds, String first, String last) {
        String sql = """
                SELECT f.film_id,
                       f.title,
                       f.release_year
                FROM   film f
                JOIN   film_actor fa ON f.film_id = fa.film_id
                JOIN   actor a       ON a.actor_id = fa.actor_id
                WHERE  a.first_name = ?
                  AND  a.last_name  = ?
                ORDER  BY f.title
                """;

        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, first);
            ps.setString(2, last);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.isBeforeFirst()) {
                    System.out.printf("⚠️  No films found for %s %s.%n", first, last);
                    return;
                }

                System.out.printf("%nFilms featuring %s %s:%n", first, last);
                System.out.printf("%-5s %-40s %-6s%n", "ID", "Title", "Year");
                System.out.println("=".repeat(55));

                while (rs.next()) {
                    System.out.printf("%-5d %-40s %-6d%n",
                            rs.getInt("film_id"),
                            rs.getString("title"),
                            rs.getInt("release_year"));
                }
            }
        } catch (Exception ex) {
            System.out.println("DB error listing films: " + ex.getMessage());
        }
    }
}
