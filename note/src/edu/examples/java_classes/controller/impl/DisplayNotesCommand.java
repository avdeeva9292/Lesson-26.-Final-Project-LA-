package edu.examples.java_classes.controller.impl;

import java.util.List;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

public class DisplayNotesCommand implements Command{

	private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();
    
	@Override
	public String execute(String request) {
		
	        StringBuilder response = new StringBuilder();
	        try {
	            List<Note> n = logic.allNotes();
	            for (Note note : n) {
	                response.append(note.toString()).append("\n");
	            }
	        } catch (Exception e) {
	            response.append("Возникла ошибка при получении записей: ").append(e.getMessage());
	        }
	        return response.toString();
	    }
	}
