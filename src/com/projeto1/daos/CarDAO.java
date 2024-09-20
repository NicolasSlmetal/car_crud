package com.projeto1.daos;

import com.projeto1.connection.DriverConnection;
import com.projeto1.exceptions.CarNotFoundException;
import com.projeto1.model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements DAO<Car> {

    private DriverConnection connection;

    public CarDAO(DriverConnection connection){
        this.connection = connection;
    }
    @Override
    public void save(Car model) {
        try(Connection context = connection.startConnection()){
            String query = "INSERT INTO cars.cars " +
                    "(car_name," +
                    "car_brand, " +
                    "car_year, " +
                    "car_color, " +
                    "car_category, " +
                    "car_country," +
                    "car_ports, " +
                    "car_price," +
                    "car_engine)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = context.prepareStatement(query);
            bindSqlParametersForInsert(model, preparedStatement);
            preparedStatement.execute();
            preparedStatement.close();
            System.out.printf("Carro %s cadastrado com sucesso!\n", model.getName());
        } catch (SQLException | ClassNotFoundException e){
            System.out.printf("Não foi possível cadastrar o carro %s\n", model.getName());
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void bindSqlParametersForInsert(Car model, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, model.getName());
        preparedStatement.setString(2, model.getBrand());
        preparedStatement.setInt(3, model.getYear());
        preparedStatement.setString(4, model.getColor());
        preparedStatement.setString(5, model.getCategory());
        preparedStatement.setString(6, model.getCountry());
        preparedStatement.setInt(7, model.getPorts());
        preparedStatement.setDouble(8, model.getPrice());
        preparedStatement.setString(9, model.getEngine());
    }

    @Override
    public List<Car> findAll() {
        List<Car> listOfCars = new ArrayList<>();
        try(Connection context = connection.startConnection()){
            String query = "SELECT * FROM cars.cars";
            Statement statement = context.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                listOfCars.add(extractCarFromResultSet(resultSet));
            }
            resultSet.close();
        }catch (SQLException | ClassNotFoundException e){
            System.out.println("Não foi possível selecionar todos os carros");
            System.out.println("Erro: " +e.getMessage());
        }
        return listOfCars;
    }

    @Override
    public Car findById(Integer id) {
        try(Connection context = connection.startConnection()){
            String query = "SELECT * FROM cars.cars WHERE car_id = ?";
            PreparedStatement preparedStatement = context.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return extractCarFromResultSet(resultSet);
            } else throw new CarNotFoundException();

        }catch (SQLException | ClassNotFoundException e){
            System.out.printf("Não foi possível selecionar a tupla com ID %d\n", id);
            System.out.println("Erro:" + e.getMessage());
            throw new CarNotFoundException();
        }
    }

    private static Car extractCarFromResultSet(ResultSet resultSet) throws SQLException {
        Car car = new Car(
                resultSet.getString("car_name"),
                resultSet.getString("car_brand"),
                resultSet.getInt("car_year"),
                resultSet.getString("car_color"),
                resultSet.getString("car_category"),
                resultSet.getString("car_country"),
                resultSet.getInt("car_ports"),
                resultSet.getDouble("car_price"),
                resultSet.getString("car_engine"));
        car.setId(resultSet.getInt("car_id"));
        return car;
    }

    @Override
    public void update(Car model) {
        try (Connection context = connection.startConnection()) {
            String query = "UPDATE cars.cars SET " +
                    "car_name = ?," +
                    "car_brand = ?," +
                    "car_year = ?, " +
                    "car_color = ?," +
                    "car_category = ?," +
                    "car_country = ?," +
                    "car_ports = ?," +
                    "car_price = ?," +
                    "car_engine = ? " +
                    "WHERE car_id = ?";
            PreparedStatement preparedStatement = context.prepareStatement(query);
            bindSqlParametersForUpdate(model, preparedStatement);
            preparedStatement.execute();
            preparedStatement.close();
            System.out.printf("Carro de ID %d atualizado\n", model.getId());
        } catch (SQLException | ClassNotFoundException e){
            System.out.printf("Não foi possível atualizar a tupla de Id %d\n", model.getId());
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void bindSqlParametersForUpdate(Car model, PreparedStatement preparedStatement) throws SQLException {
        bindSqlParametersForInsert(model, preparedStatement);
        preparedStatement.setInt(10, model.getId());
    }
    @Override
    public void delete(Integer id) {
        try(Connection context = connection.startConnection()){
            String query = "DELETE FROM cars.cars WHERE car_id = ?";
            PreparedStatement preparedStatement = context.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            preparedStatement.close();
            System.out.printf("Carro com ID %d deletado\n", id);
        } catch (SQLException | ClassNotFoundException e){
            System.out.printf("Não foi possível deletar o Id %d\n", id);
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
