/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default
 * .txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit
 * this template
 */
package dataAccess;


import entities.LoggedVehicle;
import entities.VehicleType;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author LA
 */
public class LogDataAccess {
	static final String PATH = "./src/data/log/log";

	public static void add(LoggedVehicle v) throws IOException {
		String date = LocalDateTime.now().format(
				DateTimeFormatter.ofPattern(
						"yyyyMMdd"));
		File file = new File(PATH + date + ".txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException ex) {
				Logger.getLogger(LogDataAccess.class.getName())
				      .log(Level.SEVERE, null, ex);
			}
		}

		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(v.toString());
		bw.newLine();

		bw.close();
		fw.close();

		System.out.println(file.exists());
		System.out.println(file);

	}

	public static List<LoggedVehicle> getLogs(String log) throws IOException {
		List<LoggedVehicle> logs = new ArrayList<>();

		final String logPath = PATH + log + ".txt";
		File file = new File(logPath);

		if (file.exists()) {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null) {
				String[] logsInform = line.split("\\|");

				String parkingID = logsInform[0];
				String ticket = logsInform[1];
				String licensePlate = logsInform[2];
				String type = logsInform[3];
				String timeIn = logsInform[4];
				String timeOut = logsInform[5];
				String priority = logsInform[6];
				String parkingFee = logsInform[7];

				LoggedVehicle v =
						new LoggedVehicle(Integer.parseInt(parkingFee),
						                  parkingID,
						                  ticket,
						                  licensePlate,
						                  VehicleType.valueOf(type),
						                  timeIn,
						                  timeOut,
						                  priority.equals("1")
						);
				System.out.println(v);
				logs.add(v);
			}
		}
		return logs;
	}
}
