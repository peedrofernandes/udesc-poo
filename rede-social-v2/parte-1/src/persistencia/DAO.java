package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;

import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

public abstract class DAO <Data> {
  protected PreparedStatement selectNextId;
  protected PreparedStatement select;
  protected PreparedStatement insert;
  protected PreparedStatement update;
  protected PreparedStatement delete;

  protected static Connection conexao;

  protected abstract int selectNextId() throws SelectException;

  public abstract void insert(Data elem) throws SelectException, InsertException;

  public abstract Data select(int id) throws SelectException;

  public abstract void update(Data elem) throws UpdateException;

  public abstract void delete(Data elem) throws DeleteException;
}
