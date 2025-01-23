package edu.examples.java_classes.controller.impl;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

public class UpdateNoteCommand implements Command{

	private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();
    
	@Override
	public String execute(String request) {
		 String response = null;
	        String[] params;
	        Note newNote;

	        params = request.split("\n");
	        newNote = new Note();

	        newNote.setId(Integer.parseInt(params[1].split("=")[1]));
	        newNote.setTitle(params[2].split("=")[1]);
	        newNote.setContent(params[3].split("=")[1]);

	        SimpleDateFormat format = new SimpleDateFormat();
	        format.applyPattern("dd.mm.yyyy");
	        Date date;
	        try {
	            date =  format.parse(params[4].split("=")[1]);
	            newNote.setD(date);

	            logic.add(newNote);
	            response = "Запись была обновлена успешно.";
	        } catch (ParseException e) {
	            e.printStackTrace();
	            response = "Запись не обновлена.";

	        }
	        return response;
	    }
	}
