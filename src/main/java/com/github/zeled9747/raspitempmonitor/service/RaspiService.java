package com.github.zeled9747.raspitempmonitor.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class RaspiService {

	public static float getCpuTemp() {

		String command = "/opt/vc/bin/vcgencmd measure_temp";
		Process proc;
		String result = "";
		try {
			proc = Runtime.getRuntime().exec(command);
			BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			result = reader.readLine();
			proc.waitFor();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		float temp = Float.valueOf(result.split("[=']", 3)[1]);
		return temp;
	}

	public static boolean isRaspberry() {
		String os = System.getProperty("os.name");
		if (os.startsWith("Linux")) {
			final File osRelease = new File("/etc", "os-release");
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(osRelease)));
				String firstLine = br.readLine();
				br.close();
				return firstLine.contains("Raspbian") ? true : false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

}
