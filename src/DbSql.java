import java.sql.*;

public class DbSql {
    Connection connection;
    DbSql() throws SQLException {
        connection = null;
        Statement stmt = null;
        try {
            String url = "jdbc:mysql://localhost:3306/studieadministration";
            connection = DriverManager.getConnection(url,"root","");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void opretStuderende(Studerende studerende) throws Exception {
        try {
            String sql = "INSERT INTO studerende (fnavn, enavn, adr, postnr, mobil, klasse) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, studerende.getFnavn());
            stmt.setString(2, studerende.getEnavn());
            stmt.setString(3, studerende.getAdresse());
            stmt.setString(4, studerende.getPostnr());
            stmt.setString(5, studerende.getMobil());
            stmt.setString(6, String.valueOf(studerende.getKlasse()));
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }
    public void opretFag(Fag fag) throws Exception {
        try {
            String sql = "INSERT INTO fag (fagnr, fagNavn) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, fag.getFagnr());
            stmt.setString(2, fag.getFagNavn());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }
    public void tilmeldFag(int stdnr, int fagnr) throws Exception {
        try {
            String sql = "INSERT INTO stud_fag (stdnr, fagnr) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, stdnr);
            stmt.setInt(2, fagnr);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public Studerende hentStamoplysninger(int stdnr) throws SQLException {
        Studerende studerende = null;
        String sql = "SELECT * FROM studerende WHERE stdnr = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, stdnr);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            studerende = new Studerende();
            studerende.setStdnr(rs.getInt("stdnr"));
            studerende.setFnavn(rs.getString("fnavn"));
            studerende.setEnavn(rs.getString("enavn"));
            studerende.setAdresse(rs.getString("adr"));
            studerende.setPostnr(rs.getString("postnr"));
            studerende.setMobil(rs.getString("mobil"));
            studerende.setKlasse(rs.getString("klasse").charAt(0));
        }
        rs.close();
        stmt.close();
        return studerende;
    }
}
