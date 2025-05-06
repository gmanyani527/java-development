package com.pluralsight;


public class Hotel {
        // Private instance variables
        private String name;
        private int numberOfSuites;
        private int numberOfRooms;
        private int bookedSuites;
        private int bookedBasicRooms;

        // Constructor 1: Defaults booked rooms to 0
        public Hotel(String name, int numberOfSuites, int numberOfRooms) {
            this.name = name;
            this.numberOfSuites = numberOfSuites;
            this.numberOfRooms = numberOfRooms;
            this.bookedSuites = 0;
            this.bookedBasicRooms = 0;
        }

        // Constructor 2: Sets all values including bookings
        public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
            this.name = name;
            this.numberOfSuites = numberOfSuites;
            this.numberOfRooms = numberOfRooms;
            this.bookedSuites = bookedSuites;
            this.bookedBasicRooms = bookedBasicRooms;
        }

        // Optional: Add getters (no setters as per instructions)
        public String getName() {
            return name;
        }

        public int getNumberOfSuites() {
            return numberOfSuites;
        }

        public int getNumberOfRooms() {
            return numberOfRooms;
        }

        public int getBookedSuites() {
            return bookedSuites;
        }

        public int getBookedBasicRooms() {
            return bookedBasicRooms;
        }
        public boolean bookRoom(int numberOfRoomsToBook, boolean isSuite) {
            if (isSuite) {
                int available = numberOfSuites - bookedSuites;
                if (numberOfRoomsToBook <= available) {
                    bookedSuites += numberOfRoomsToBook;
                    return true;
                }
            } else {
                int available = numberOfRooms - bookedBasicRooms;
                if (numberOfRoomsToBook <= available) {
                    bookedBasicRooms += numberOfRoomsToBook;
                    return true;
                }
            }
            return false; // Not enough rooms
        }

        public int getAvailableSuites() {
            return numberOfSuites - bookedSuites;
        }
        public int getAvailableRooms() {
            return numberOfRooms - bookedBasicRooms;
        }


    }



