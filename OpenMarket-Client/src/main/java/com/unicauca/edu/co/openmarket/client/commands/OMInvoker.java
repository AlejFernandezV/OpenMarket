/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicauca.edu.co.openmarket.client.commands;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahurtado
 */
public class OMInvoker {
    
    private List<OMCommand> myCommands;
    private OMCommand currentCommand;
    
    public OMInvoker(){
        myCommands = new ArrayList<>();
        currentCommand=null;
    }
    
    public void addCommand(OMCommand actualCommand){
        currentCommand = actualCommand;
        
    }
    
    public void execute(){
        myCommands.add(currentCommand);
        currentCommand.make();
    }
    
    public void unexecute(){
        if (!myCommands.isEmpty()){
            int index = myCommands.size()-1;
            OMCommand command= myCommands.get(index);
            command.unmake();
            myCommands.remove(index);
        }
        
    }
    
    public boolean hasMoreCommands(){
        return !myCommands.isEmpty();
    }
}
