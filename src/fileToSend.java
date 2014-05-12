
public class fileToSend{
	String filename;
	long   size;
	String path;
	String type;

	private static final String getExtension(final String filename) {
		  if (filename == null) return null;
		  final String afterLastSlash = filename.substring(filename.lastIndexOf('/') + 1);
		  final int afterLastBackslash = afterLastSlash.lastIndexOf('\\') + 1;
		  final int dotIndex = afterLastSlash.indexOf('.', afterLastBackslash);
		  return (dotIndex == -1) ? "" : afterLastSlash.substring(dotIndex + 1);
	}
	
	fileToSend(String fn, long sz, String ph){
			filename = fn;
			size = sz;
			path = ph;
			type = fileToSend.getExtension(fn);
	}
}