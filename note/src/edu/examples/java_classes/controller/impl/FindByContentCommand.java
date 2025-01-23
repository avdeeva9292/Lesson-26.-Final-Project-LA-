package edu.examples.java_classes.controller.impl;

import java.util.List;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

public class FindByContentCommand implements Command {
	private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();
    
	@Override
	public String execute(String request) {
		  String response = "";
	        String[] params;
	        List<Note> notesByContent;

	        params = request.split("\n");
	        notesByContent = logic.find(params[1]);

	        for (Note n : notesByContent) {
	            response = response + n.toString();
	        }
	        return response;
	    }
	}
