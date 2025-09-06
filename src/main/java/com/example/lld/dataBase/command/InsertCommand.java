package com.example.lld.dataBase.command;

import com.example.lld.dataBase.repository.TableRepository;

import java.util.Map;

public class InsertCommand implements Command {
    private final TableRepository repo; private final Map<String,Object> values;
    public InsertCommand(TableRepository repo, Map<String,Object> values){ this.repo = repo; this.values = values; }
    @Override public int execute(){ return repo.insert(values); }
}
