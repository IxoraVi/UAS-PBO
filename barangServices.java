import java.sql.SQLException;
import java.util.List;

public interface barangServices {
    Barang insert(Barang brg) throws SQLException;
    void update(Barang brg) throws SQLException;
    void delete(String nobarang) throws SQLException;
    List getAll() throws SQLException;
}
