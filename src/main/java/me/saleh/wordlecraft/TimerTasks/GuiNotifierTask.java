package me.saleh.wordlecraft.TimerTasks;
import me.saleh.wordlecraft.utils.MessageUtil;
import java.util.TimerTask;
public class GuiNotifierTask extends TimerTask {
    int Seconds = 60;
    @Override
    public void run() {
        Seconds--;
        if(Seconds == 30 || Seconds == 10 || (Seconds <= 5 && Seconds > 0)){
            MessageUtil.Broadcast("%s seconds left",Seconds);
        }
    }
}
