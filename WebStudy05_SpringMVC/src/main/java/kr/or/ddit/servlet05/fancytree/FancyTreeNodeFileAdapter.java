package kr.or.ddit.servlet05.fancytree;

import java.io.File;

public class FancyTreeNodeFileAdapter implements FancytreeNode<File>{

	private File adaptee;
	
	public FancyTreeNodeFileAdapter(File adaptee) {
		super();
		this.adaptee = adaptee;		
	}

	@Override
	public String getKey() {
		return adaptee.getName();
	}

	@Override
	public String getTitle() {
		return adaptee.getName();
	}

	@Override
	public boolean isFolder() {
		return adaptee.isDirectory();
	}

	@Override
	public boolean isLazy() {
		return adaptee.isDirectory();
	}

	@Override
	public File getData() {
		return adaptee;
	}

}
