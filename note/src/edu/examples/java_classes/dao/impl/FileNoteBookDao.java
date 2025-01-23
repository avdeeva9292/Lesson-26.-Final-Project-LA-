package edu.examples.java_classes.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;

public class FileNoteBookDao implements NoteBookDao {
	

	
	  @Override
	public void save(Note n) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("resources/notes.txt", true));
			writer.write(n.getId() + " " + format.format(new Date()) + " " + n.getTitle() + " " + n.getContent());
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			System.err.println("Ошибка при сохранении файла");
		}
	}

	@Override
	public List<Note> allNotes() {

		List<Note> listNote = new ArrayList<>();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy/HH-mm");
		try {
			InputStreamReader reader = new InputStreamReader(new FileInputStream("resources/notes.txt"), "UTF-8");
			BufferedReader breader = new BufferedReader(reader);
			String line;
			while ((line = breader.readLine()) != null) {

				String[] part = line.split(" ", 4);
				int id = Integer.parseInt(part[0]);
				Date date = format.parse(part[1]);
				listNote.add(new Note(id, part[2], part[3], date));
			}
			reader.close();
		} catch (IOException e) {
			System.err.println("Файл не найден");
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

		return listNote;
	}

}
