import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class StreamOutputObject extends ObjectOutputStream {

	public StreamOutputObject(OutputStream out) throws IOException {
		super(out);
	}

	@Override
	protected void writeStreamHeader() throws IOException {}	
}
