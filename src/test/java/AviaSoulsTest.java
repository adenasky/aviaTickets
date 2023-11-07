import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {
    @Test
    public void testSearchZeroTickets() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "EKB", 5000, 12, 14);
        Ticket ticket2 = new Ticket("MSK", "EKB", 3000, 10, 13);
        Ticket ticket3 = new Ticket("MSK", "SPB", 7000, 12, 13);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        Ticket[] actual = aviaSouls.search("MSK", "NSB");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testSearchOneTicket() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "EKB", 5000, 12, 14);
        Ticket ticket2 = new Ticket("MSK", "EKB", 3000, 10, 13);
        Ticket ticket3 = new Ticket("MSK", "SPB", 7000, 12, 13);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        Ticket[] actual = aviaSouls.search("MSK", "SPB");
        Ticket[] expected = {ticket3};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testSearchSeveralTicketsWithSorting() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "EKB", 5000, 12, 14);
        Ticket ticket2 = new Ticket("MSK", "EKB", 3000, 10, 13);
        Ticket ticket3 = new Ticket("MSK", "EKB", 7000, 12, 14);
        Ticket ticket4 = new Ticket("MSK", "SPB", 2000, 12, 13);
        Ticket ticket5 = new Ticket("MSK", "EKB", 5000, 9, 12);
        Ticket ticket6 = new Ticket("MSK", "SPB", 5000, 11, 12);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Ticket[] actual = aviaSouls.search("MSK", "EKB");
        Ticket[] expected = {ticket2, ticket1, ticket5, ticket3};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testSearchZeroTicketsWithComparator() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "EKB", 5000, 12, 16);
        Ticket ticket2 = new Ticket("MSK", "EKB", 3000, 10, 15);
        Ticket ticket3 = new Ticket("MSK", "EKB", 7000, 12, 15);
        Ticket ticket4 = new Ticket("MSK", "SPB", 2000, 12, 13);
        Ticket ticket5 = new Ticket("MSK", "EKB", 5000, 9, 11);
        Ticket ticket6 = new Ticket("MSK", "SPB", 5000, 11, 12);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = aviaSouls.search("MSK", "NSB", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testSearchOneTicketWithComparator() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "EKB", 5000, 12, 16);
        Ticket ticket2 = new Ticket("MSK", "EKB", 3000, 10, 15);
        Ticket ticket3 = new Ticket("MSK", "NSB", 7000, 12, 15);
        Ticket ticket4 = new Ticket("MSK", "SPB", 2000, 12, 13);
        Ticket ticket5 = new Ticket("MSK", "EKB", 5000, 9, 11);
        Ticket ticket6 = new Ticket("MSK", "SPB", 5000, 11, 12);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = aviaSouls.search("MSK", "NSB", comparator);
        Ticket[] expected = {ticket3};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testSearchSeveralTicketsWithComparatorSorting() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "EKB", 5000, 12, 16);
        Ticket ticket2 = new Ticket("MSK", "EKB", 3000, 10, 15);
        Ticket ticket3 = new Ticket("MSK", "EKB", 7000, 12, 15);
        Ticket ticket4 = new Ticket("MSK", "SPB", 2000, 12, 13);
        Ticket ticket5 = new Ticket("MSK", "EKB", 5000, 9, 11);
        Ticket ticket6 = new Ticket("MSK", "SPB", 5000, 11, 12);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = aviaSouls.search("MSK", "EKB", comparator);
        Ticket[] expected = {ticket5, ticket3, ticket1, ticket2};

        Assertions.assertArrayEquals(actual, expected);
    }
}