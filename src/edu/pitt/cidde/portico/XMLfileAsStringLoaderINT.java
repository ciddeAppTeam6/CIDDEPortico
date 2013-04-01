package edu.pitt.cidde.portico;
public interface XMLfileAsStringLoaderINT<T>
{	
	public void onFinishedDownload(T result);
	public void onProgressUpdate(Integer[] progress);
}
