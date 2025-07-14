package Reflection;

import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.sql.SQLClientInfoException;

public class EmployeeReflect3 {

    public void add(int eno, String ename, String eaddr) throws ClassCastException, ClassFormatError{

    }
    public String search(int eno) throws FileAlreadyExistsException, FileNotFoundException{
        return "Success";
    }

    public String delete (int eno) throws SQLClientInfoException{
        return "success";
    }
}
