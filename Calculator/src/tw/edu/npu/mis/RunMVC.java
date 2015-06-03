/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

/**
 *
 * @author Perfect978
 */
public class RunMVC {
    
    public RunMVC()
    {
        Calculator myModel = new Calculator();
        View myView = new View();

        myModel.addObserver(myView);
        Controller myController = new Controller();
        myController.addModel(myModel);
        myController.addView(myView);
        myController.initModel(5);
        myView.addController(myController);
    }
    
    public static void main(String[] args){
	RunMVC mainRunMVC = new RunMVC();
        //View myView = new View();
    }
}
