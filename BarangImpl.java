import java.sql.*;
import java.util.*;

public class BarangImpl implements barangServices {
    @Override
    public Barang insert(Barang brg) throws SQLException {
        PreparedStatement st = koneksi.getConnection().prepareStatement("insert into databarang values(?,?,?,?,?)");
        st.setString(1, brg.getNobarang());
        st.setString(2, brg.getNama());
        st.setInt(3, brg.getHarga());
        st.setInt(4, brg.getQty());
        st.setInt(5, brg.getTotalbarang());
        st.executeUpdate();
        return brg;
    }

    @Override
    public void update(Barang brg) throws SQLException {
        PreparedStatement st = koneksi.getConnection().prepareStatement("update databarang set nama=?,harga=?,qty=?,total=? where nobarang=?");
        st.setString(1, brg.getNama());
        st.setInt(2, brg.getHarga());
        st.setInt(3, brg.getQty());
        st.setInt(4, brg.getTotalbarang());
        st.setString(5, brg.getNobarang());
        st.executeUpdate();

    }

    @Override
    public void delete(String nobarang) throws SQLException {
        PreparedStatement st = koneksi.getConnection().prepareStatement("delete from databarang  where nobarang=?");
        st.setString(1, nobarang);
        st.executeUpdate();
    }

    @Override
    public List getAll() throws SQLException {
        Statement st = koneksi.getConnection().createStatement();
        ResultSet rs = st.executeQuery("select * from databarang");
        List list = new ArrayList();
        while (rs.next()) {
            Barang p = new Barang();
            p.setNobarang(rs.getString("nobarang"));
            p.setNama(rs.getString("nama"));
            p.setHarga(rs.getInt("harga"));
            p.setQty(rs.getInt("qty"));
            p.setTotalbarang(rs.getInt("total"));
            list.add(p);
        }
        return list;
    }
}

