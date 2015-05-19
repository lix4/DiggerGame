import java.util.ArrayList;


public class GameThread extends Thread {
	public ArrayList<UpdatedEntity> entitiesToUpdate;

	public GameThread(ArrayList<UpdatedEntity> entitiesToUpdate)
	{
		this.entitiesToUpdate = entitiesToUpdate;
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			
			for (UpdatedEntity updatedEntity : this.entitiesToUpdate)
			{
				updatedEntity.update();
			}
			
			
			try {
				Thread.sleep(33);
			} catch (InterruptedException exception) {
				// TODO Auto-generated catch-block stub.
				exception.printStackTrace();
			}
		}
	}
}
