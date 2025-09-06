package com.example.lld.dataBase.command;

import com.example.lld.dataBase.repository.TableRepository;

import java.util.Map;

public class DeleteCommand implements Command {
    private final TableRepository repo; private final Map<String,Object> filter;
    public DeleteCommand(TableRepository repo, Map<String,Object> filter){ this.repo = repo; this.filter = filter; }
    @Override public int execute(){ return repo.delete(filter); }
}
