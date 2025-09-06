package com.example.lld.dataBase.command;

import com.example.lld.dataBase.repository.TableRepository;

import java.util.Map;

public class UpdateCommand implements Command {
    private final TableRepository repo; private final Map<String,Object> filter; private final Map<String,Object> updates;
    public UpdateCommand(TableRepository repo, Map<String,Object> filter, Map<String,Object> updates){ this.repo = repo; this.filter = filter; this.updates = updates; }
    @Override public int execute(){ return repo.update(filter, updates); }
}
