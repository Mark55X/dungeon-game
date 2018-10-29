package com.onn.dungeongame.item;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.net.*;
import java.io.*;
import java.lang.*;

public class ItemManager {

	private ArrayList<Item> items;
	private String path;

	public ItemManager() {
		items = new ArrayList<>();
		items.add(Item.wood1Item.createNew(96, 160));
		items.add(Item.wood1Item.createNew(120, 200));
	}

	public void tick() {
		Iterator<Item> it = items.iterator();
		while(it.hasNext()) {
			Item i = it.next();
			i.tick();
			if(i.isPickedUp()) {
				it.remove();
			}
		}
	}

	public void render(Graphics g) {
		for(int i = 0; i < items.size(); i++) {
			items.get(i).render(g);
		}
	}

	public void addItem(Item i) {
		items.add(i);
	}

	public void loadFromFile(String path) {
		this.path = path;

		try {
			String fileData = "";

			BufferedReader br = new BufferedReader(new FileReader(new File(path)));
			String line;

			while((line = br.readLine()) != null) {
				fileData += line + "\n";
			}

			br.close();

			String[] tokens = fileData.split("\\s+");

            if(tokens.length == 0) return;

			for(int i = 0; i < tokens.length; i += 4) {
				int id = Integer.parseInt(tokens[i]);
				int x = Integer.parseInt(tokens[i + 1]);
				int y = Integer.parseInt(tokens[i + 2]);
                int count = Integer.parseInt(tokens[i + 3]);


                Item item = Item.items[id].createNew(x, y);
                item.setCount(count);

				items.add(item);
			}
		} catch(IOException ex) {
			System.out.println("Failed to open \'" + path + "\': " + ex.getMessage());
			System.exit(1);
		} catch(ArrayIndexOutOfBoundsException|NumberFormatException ex) {
			System.out.println("Invalid item file format");
			System.exit(1);
		}
	}

    public void save() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)));

            for(Item i : items) {
                int id = i.getId();
                int x = i.getX();
                int y = i.getY();
                int pickedUp = 0; if(i.isPickedUp()) pickedUp = 1;
                int count = i.getCount();
                Rectangle bounds = i.getBounds();

                bw.write(String.valueOf(id)                       + " " +
                         String.valueOf(x)                        + " " +
                         String.valueOf(y)                        + " " +
                         String.valueOf(count)                    + "\n");
            }

            bw.close();
        } catch(IOException ex) {
            System.out.println("Failed to save \'" + path + "\': " + ex.getMessage());
        }
    }

}
