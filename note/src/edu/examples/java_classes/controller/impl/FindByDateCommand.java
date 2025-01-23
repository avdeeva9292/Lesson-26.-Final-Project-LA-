package edu.examples.java_classes.controller.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

public class FindByDateCommand implements Command{

	private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();
    
	@Override
	public String execute(String request) {
		
	        SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yyyy");
	        String response = "";
	        String[] params;
	       	List<Note> notesByDate;

	        params = request.split("\n");
	        notesByDate = logic.find(params[1]);

	        for (Note n : notesByDate) {
	            response = response + n.toString();
	        }
	        return response;
	    }
	}
