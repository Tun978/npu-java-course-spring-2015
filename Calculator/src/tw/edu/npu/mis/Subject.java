/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author STP
 */
public class Subject {
    List<Event> evn = new ArrayList<>();
    
    public void attach(Event o)
    {
        evn.add(o);
    }
    
    public void detach(Event o)
    {
        evn.remove(o);
    }
}
