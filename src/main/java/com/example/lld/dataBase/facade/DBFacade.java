package com.example.lld.dataBase.facade;

import com.example.lld.dataBase.command.DeleteCommand;
import com.example.lld.dataBase.command.InsertCommand;
import com.example.lld.dataBase.command.UpdateCommand;
import com.example.lld.dataBase.factory.EntityFactory;
import com.example.lld.dataBase.manager.DBManager;
import com.example.lld.dataBase.model.Column;
import com.example.lld.dataBase.model.DataType;
import com.example.lld.dataBase.repository.TableRepository;

import java.util.Map;

public final class DBFacade {
    private final DBManager mgr = DBManager.getInstance();
    public void initDemo(){
        mgr.createDatabase("crm");
        Column id = EntityFactory.column("id", DataType.INT, true);
        Column name = EntityFactory.column("name", DataType.STRING, true);
        Column city = EntityFactory.column("city", DataType.STRING, false);
        var schema = EntityFactory.schema(id, name, city);
        mgr.createTable("crm", "customers", schema);
        TableRepository repo = mgr.table("crm","customers");
        repo.createIndex("idx_name","name");
        new InsertCommand(repo, Map.of("id",1, "name","Alice","city","Pune")).execute();
        new InsertCommand(repo, Map.of("id",2, "name","Bob","city","Mumbai")).execute();
        repo.printAll();
        new UpdateCommand(repo, Map.of("name","Alice"), Map.of("city","Delhi")).execute();
        repo.printAll();
        new DeleteCommand(repo, Map.of("name","Bob")).execute();
        repo.printAll();
    }
}
