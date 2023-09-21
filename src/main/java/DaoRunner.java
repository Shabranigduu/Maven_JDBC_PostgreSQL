import dao.TicketDao;
import entity.TicketEntity;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class DaoRunner {
    public static void main(String[] args) throws SQLException {

//        TicketEntity ticket = TicketEntity.builder()
//                .passengerNo("2323423")
//                .passengerName("Ivan")
//                .flightId(2L)
//                .seatNo("A333")
//                .cost(BigDecimal.valueOf(45.00))
//                .build();
//        addNew(ticket);

        TicketEntity ticket1 = getById(1L);
        System.out.println(ticket1);

        System.out.println(update(56L, "321321", "Вася Пупкин", 3L, "B2", BigDecimal.valueOf(200)));

        System.out.println(getAll());

    }

    private static void addNew(TicketEntity ticket) throws SQLException {
        TicketDao dao = TicketDao.getInstance();

        System.out.println(dao.addNew(ticket));
    }

    private static TicketEntity getById(Long id) {
        TicketDao dao = TicketDao.getInstance();
        TicketEntity ticket = dao.getById(id);
        return ticket;
    }

    private static List<TicketEntity> getAll() {
        TicketDao dao = TicketDao.getInstance();
        return dao.getAll();
    }

    private static TicketEntity update(Long id, String passengerNo, String passengerName, Long flightId, String seatNo, BigDecimal cost) throws SQLException {
        TicketDao dao = TicketDao.getInstance();
        return dao.update(id, passengerNo, passengerName, flightId, seatNo, cost);
    }
}
