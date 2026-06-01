package examen.gomez.izan.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import examen.gomez.izan.beans.Laboratorio;
import examen.gomez.izan.motores.MotorFactory;
import examen.gomez.izan.motores.MotorSQL;

public class LaboratiorioDAOImpl extends AbstractDAO<Laboratorio> {

    private static final String AUTOR_EXAMEN = "IZAN_GOMEZ_DAM2";

    private static final String SQL_FIND_ALL =
            "SELECT * " +
            "FROM laboratorio " +
            "ORDER BY id";

    private static final String SQL_FIND =
            "SELECT * " +
            "FROM laboratorio " +
            "WHERE id = ?";

    private static final String SQL_INSERT =
            "INSERT INTO laboratorio " +
            "(" +
            "nombre, " +
            "pais, " +
            "autor_examen" +
            ") " +
            "VALUES " +
            "(" +
            "?, ?, ?" +
            ")";

    private static final String SQL_UPDATE =
            "UPDATE laboratorio " +
            "SET " +
            "nombre = ?, " +
            "pais = ? " +
            "WHERE id = ?";

    private static final String SQL_DELETE =
            "DELETE FROM laboratorio " +
            "WHERE id = ?";

    public LaboratiorioDAOImpl(MotorSQL motorSQL) {
        super(motorSQL);
    }

    @Override
    public void add(Laboratorio laboratorio) {

        try {

            motorSQL.connect();
            motorSQL.prepare(SQL_INSERT);

            motorSQL.getPs().setString(1, laboratorio.getNombre());
            motorSQL.getPs().setString(2, laboratorio.getPais());
            motorSQL.getPs().setString(3, AUTOR_EXAMEN);

            int rows = motorSQL.executeUpdate();

            System.out.println("INSERTADOS: " + rows);

        } catch (Exception e) {

            printError(e);

        } finally {

            motorSQL.close();
        }
    }

    @Override
    public void update(int id, Laboratorio laboratorio) {

        try {

            motorSQL.connect();
            motorSQL.prepare(SQL_UPDATE);

            motorSQL.getPs().setString(1, laboratorio.getNombre());
            motorSQL.getPs().setString(2, laboratorio.getPais());
            motorSQL.getPs().setInt(3, id);

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
    public Laboratorio find(int id) {

        Laboratorio laboratorio = null;

        try {

            motorSQL.connect();
            motorSQL.prepare(SQL_FIND);

            motorSQL.getPs().setInt(1, id);

            ResultSet rs = motorSQL.executeQuery();

            if (rs.next()) {
                laboratorio = mapLaboratorio(rs);
            }

        } catch (Exception e) {

            printError(e);

        } finally {

            motorSQL.close();
        }

        return laboratorio;
    }

    @Override
    public ArrayList<Laboratorio> findAll() {

        ArrayList<Laboratorio> laboratorio = new ArrayList<>();

        try {

            motorSQL.connect();
            motorSQL.prepare(SQL_FIND_ALL);

            ResultSet rs = motorSQL.executeQuery();

            while (rs.next()) {
                laboratorio.add(mapLaboratorio(rs));
            }

        } catch (Exception e) {

            printError(e);

        } finally {

            motorSQL.close();
        }

        return laboratorio;
    }

    private Laboratorio mapLaboratorio(ResultSet rs) throws Exception {

        Laboratorio laboratorio = new Laboratorio();

        laboratorio.setId(rs.getInt("id"));
        laboratorio.setNombre(rs.getString("nombre"));
        laboratorio.setPais(rs.getString("pais"));
        laboratorio.setAutorExamen(rs.getString("autor_examen"));

        return laboratorio;
    }

    public static void main(String[] args) {

        LaboratiorioDAOImpl laboratorioDAO =
                new LaboratiorioDAOImpl(
                        MotorFactory.create(MotorFactory.POSTGRE));



        ArrayList<Laboratorio> lst = laboratorioDAO.findAll();

        for (Laboratorio a : lst) {
            System.out.println(a);
        }
    }
}