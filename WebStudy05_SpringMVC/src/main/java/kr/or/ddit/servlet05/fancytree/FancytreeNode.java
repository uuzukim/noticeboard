package kr.or.ddit.servlet05.fancytree;

public interface FancytreeNode<T> extends Comparable<FancytreeNode<T>> {
	public String getKey();
	public String getTitle();
	public boolean isFolder();
	public boolean isLazy();
	
	public T getData();
	
	@Override
	default int compareTo(FancytreeNode<T> o) {
		if(isFolder() ^ o.isFolder()) {
			return o.isFolder() ? 1 : -1;
		}else {
			return getTitle().toLowerCase().compareTo(o.getTitle().toLowerCase());
		}
	}
}
