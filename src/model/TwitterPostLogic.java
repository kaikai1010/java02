package model;

import java.util.List;

public class TwitterPostLogic {
	public void execute(List<Twitter> tList, Twitter t) {
		tList.add(0, t);
	}
}
