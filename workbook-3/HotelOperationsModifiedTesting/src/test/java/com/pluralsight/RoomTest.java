package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class RoomTest {
    @Test
    public void testCheckInSetsRoomOccupiedAndDirty() {
        Room room = new Room(2, 150.0);
        room.checkIn();
        assertTrue(room.isOccupied(), "Room should be occupied after check-in");
        assertTrue(room.isDirty(), "Room should be dirty after check-in");
    }

    @Test
    public void testCheckInDoesNothingIfAlreadyOccupied() {
        Room room = new Room(1, 100.0);
        room.checkIn();
        room.checkIn(); // attempt to check in again

        assertTrue(room.isOccupied(), "Room should still be occupied");
        assertTrue(room.isDirty(), "Room should still be dirty");
    }

    @Test
    public void testCheckOutSetsRoomNotOccupied() {
        Room room = new Room(1, 100.0);
        room.checkIn();
        room.checkOut();

        assertFalse(room.isOccupied(), "Room should not be occupied after checkout");
    }

    @Test
    public void testCleanRoomOnlyWhenNotOccupied() {
        Room room = new Room(1, 100.0);
        room.checkIn();      // Room is now occupied and dirty
        room.cleanRoom();    // Should NOT clean because it's still occupied

        assertTrue(room.isDirty(), "Room should remain dirty if occupied");

        room.checkOut();     // Now unoccupied
        room.cleanRoom();    // Should clean now
        assertFalse(room.isDirty(), "Room should be clean after cleaning while unoccupied");
    }

    @Test
    public void testIsAvailableReturnsTrueOnlyIfNotOccupiedAndClean() {
        Room room = new Room(1, 100.0);
        assertTrue(room.isAvailable(), "Room should be available when not occupied and clean");

        room.checkIn(); // now it's occupied and dirty
        assertFalse(room.isAvailable(), "Room should not be available when occupied");

        room.checkOut();
        assertFalse(room.isAvailable(), "Room should not be available when dirty");

        room.cleanRoom();
        assertTrue(room.isAvailable(), "Room should be available after checkout and cleaning");
    }
}