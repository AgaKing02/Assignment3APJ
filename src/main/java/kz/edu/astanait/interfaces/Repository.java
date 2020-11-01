package kz.edu.astanait.interfaces;

import java.sql.Connection;

public interface Repository {
    Connection getConnection();
}
