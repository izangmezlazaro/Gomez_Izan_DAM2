package examen.gomez.izan.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import examen.gomez.izan.beans.MuestraADN;
import examen.gomez.izan.motores.MotorSQL;

public class MuestraADNDAOImpl extends AbstractDAO<MuestraADN> {

    // findMuestraADNWithDetail ahora delega correctamente en findMuestraWithDetail
    public MuestraADN findMuestraADNWithDetail(int id) {
        return findMuestraWithDetail(id);
    }

private static final String SQL_FIND_ALL =
        "SELECT * FROM MUESTRAADN ORDER BY id";

private static final String SQL_FIND =
        "SELECT * FROM MUESTRAADN WHERE id = ?";

private static final String SQL_INSERT =
        "INSERT INTO MUESTRAADN " +
        "(codigo, tipo, fecha_extraccion, laboratorio_id, autor_examen) " +
        "VALUES (?, ?, ?, ?, ?)";

private static final String SQL_UPDATE =
        "UPDATE MUESTRAADN " +
        "SET codigo = ?, " +
        "tipo = ?, " +
        "fecha_extraccion = ?, " +
        "laboratorio_id = ?, " +
        "autor_examen = ? " +
        "WHERE id = ?";

private static final String SQL_DELETE =
        "DELETE FROM MUESTRAADN WHERE id = ?";

private static final String SQL_FIND_BY_LABORATORIO =
        "SELECT * FROM MUESTRAADN WHERE laboratorio_id = ? ORDER BY id";

    private static final String SQL_MUESTRAADN_WITH_DETAIL =
        "SELECT " +
                    "M.ID, " +
                    "M.CODIGO, " +
                    "M.TIPO, " +
                    "M.FECHA_EXTRACCION, " +
                    "M.LABORATORIO_ID, " +
                    "M.AUTOR_EXAMEN, " +

                    "D.ID DETALLE_ID, " +
                    "D.MUTACION_DETECTADA, " +
                    "D.PORCENTAJE_COINCIDENCIA, " +
                    "D.OBSERVACIONES " +

        "FROM MUESTRAADN M " +

        "INNER JOIN DETALLE_MUESTRAADN D " +
        "ON M.ID = D.MUESTRAADN_ID " +

        "WHERE M.ID = ? " +

        "ORDER BY M.ID";

    private static final String SQL_MUESTRAADN_ACTIVOS =
        "SELECT " +
                    "M.ID, " +
                    "M.CODIGO, " +
                    "M.TIPO, " +
                    "M.FECHA_EXTRACCION, " +
                    "M.LABORATORIO_ID, " +
                    "M.AUTOR_EXAMEN, " +

                    "L.ID LABORATORIO_ID, " +
                    "L.NOMBRE LABORATORIO_NOMBRE, " +
                    "L.PAIS LABORATORIO_PAIS, " +

                    "D.ID DETALLE_ID, " +
                    "D.MUTACION_DETECTADA, " +
                    "D.PORCENTAJE_COINCIDENCIA, " +
                    "D.OBSERVACIONES " +

        "FROM MUESTRAADN M " +

        "INNER JOIN LABORATORIO L " +
        "ON M.LABORATORIO_ID = L.ID " +

        "INNER JOIN DETALLE_MUESTRAADN D " +
        "ON M.ID = D.MUESTRAADN_ID " +

        "WHERE M.ACTIVO = TRUE " +

        "ORDER BY M.ID";

    public MuestraADNDAOImpl(MotorSQL motorSQL) {
        super(motorSQL);
    }

    @Override
    public void add(MuestraADN muestraADN) {
        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_INSERT);

            motorSQL.getPs().setString(1, muestraADN.getCodigo());
            motorSQL.getPs().setString(2, muestraADN.getTipo());
            motorSQL.getPs().setString(3, muestraADN.getFechaExtraccion());
            motorSQL.getPs().setInt(4, muestraADN.getLaboratorioID().getId());
            motorSQL.getPs().setString(5, muestraADN.getAutorExamen());

            int rows = motorSQL.executeUpdate();
            System.out.println("INSERTADOS: " + rows);

        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }
    }

    @Override
    public void update(int id, MuestraADN muestraADN) {
        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_UPDATE);

            motorSQL.getPs().setString(1, muestraADN.getCodigo());
            motorSQL.getPs().setString(2, muestraADN.getTipo());
            motorSQL.getPs().setString(3, muestraADN.getFechaExtraccion());
            motorSQL.getPs().setInt(4, muestraADN.getLaboratorioID().getId());
            motorSQL.getPs().setString(5, muestraADN.getAutorExamen());
            motorSQL.getPs().setInt(6, id);

            int rows = motorSQL.executeUpdate();
            System.out.println("ACTUALIZADOS: " + rows);

        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }
    }

    @Override
    public void delete(int id) {
        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_DELETE);

            motorSQL.getPs().setInt(1, id);

            int rows = motorSQL.executeUpdate();
            System.out.println("BORRADOS: " + rows);

        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }
    }

    @Override
    public MuestraADN find(int id) {

        MuestraADN m = null;

        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_FIND);

            motorSQL.getPs().setInt(1, id);

            ResultSet rs = motorSQL.executeQuery();

            if (rs.next()) {
                m = mapMuestraADN(rs);
            }

        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }

        return m;
    }

    @Override
    public ArrayList<MuestraADN> findAll() {

        ArrayList<MuestraADN> lista = new ArrayList<>();

        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_FIND_ALL);

            ResultSet rs = motorSQL.executeQuery();

            while (rs.next()) {
                lista.add(mapMuestraADN(rs));
            }

        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }

        return lista;
    }

    public ArrayList<MuestraADN> findByLaboratorio(int idLaboratorio) {

        ArrayList<MuestraADN> lista = new ArrayList<>();

        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_FIND_BY_LABORATORIO);

            motorSQL.getPs().setInt(1, idLaboratorio);

            ResultSet rs = motorSQL.executeQuery();

            while (rs.next()) {
                lista.add(mapMuestraADN(rs));
            }

        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }

        return lista;
    }

    public MuestraADN findMuestraWithDetail(int id) {

        MuestraADN muestraADN = null;

        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_MUESTRAADN_WITH_DETAIL);

            motorSQL.getPs().setInt(1, id);

            ResultSet rs = motorSQL.executeQuery();

            if (rs.next()) {

                muestraADN = new MuestraADN();

                muestraADN.setId(rs.getInt(1));
                muestraADN.setCodigo(rs.getString(2));
                muestraADN.setTipo(rs.getString(3));
                muestraADN.setFechaExtraccion(rs.getString(4));

                muestraADN.getLaboratorioID().setId(rs.getInt(5));

                muestraADN.setAutorExamen(rs.getString(6));

                muestraADN.getDetalle().setId(rs.getInt(7));
                muestraADN.getDetalle().setMutacionDetectada(rs.getBoolean(8));
                muestraADN.getDetalle().setPorcentajeCoincidencia(rs.getDouble(9));
                muestraADN.getDetalle().setObservaciones(rs.getString(10));
            }

        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }

        return muestraADN;
    }

    private MuestraADN mapMuestraADN(ResultSet rs) throws Exception {

        MuestraADN muestraADN = new MuestraADN();

        muestraADN.setId(rs.getInt("id"));
        muestraADN.setCodigo(rs.getString("codigo"));
        muestraADN.setTipo(rs.getString("tipo"));
        muestraADN.setFechaExtraccion(rs.getString("fecha_extraccion"));
        muestraADN.setAutorExamen(rs.getString("autor_examen"));

        muestraADN.getLaboratorioID().setId(rs.getInt("laboratorio_id"));

        return muestraADN;
    }
}
