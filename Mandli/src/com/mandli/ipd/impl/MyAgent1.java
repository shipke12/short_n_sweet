package com.mandli.ipd.impl;

import com.mandli.ipd.Action;
import com.mandli.ipd.ActionProcessor;
import com.mandli.ipd.Agent;
import com.mandli.ipd.Result;

public class MyAgent1 implements Agent {
	
	private Action currentAgent;
	private Action prevOpponent;
	
	public MyAgent1() {
		currentAgent = Action.DEFECT;
		
	}
	public void performAction(ActionProcessor actionProcessor) {
		
		//start with defect
		Result result = actionProcessor.submitAction(currentAgent);
		prevOpponent = result.getOpponentAction();
		
		//if A and B are cooperate, stay at cooperate, they could switch to defect and being a defect would be only 1 point
		if((prevOpponent.compareTo(Action.COOPERATE)==0)&&(currentAgent.compareTo(Action.COOPERATE)==0)) {
			currentAgent = Action.COOPERATE;
	
		//if A and B are defect, stay at defect, they could go cooperate and you still have points
		} else if((prevOpponent.compareTo(Action.DEFECT)==0)&&(currentAgent.compareTo(Action.DEFECT)==0)) {
			currentAgent = Action.DEFECT;
			
		//if A is cooperate and B is defect, change to defect so maybe you'll get points again
		} else if((prevOpponent.compareTo(Action.COOPERATE)==0)&&(currentAgent.compareTo(Action.DEFECT)==0)) {
			currentAgent = Action.DEFECT;
			
		//if A is defect and B is cooperate, stay at defect because points
		} else if((prevOpponent.compareTo(Action.DEFECT)==0)&&(currentAgent.compareTo(Action.COOPERATE)==0)) {
			currentAgent = Action.DEFECT;
		}
		
		
		//These comments were my thinking process, I over-thought it I think
		
		//actionProcessor.submitAction(prevOpponent);
		//actionProcessor.submitAction(Math.random() < 0.5 ? Action.COOPERATE : Action.DEFECT);
		
		//first test agent c and agent d and get opponent actions
		
		//Result result = actionProcessor.submitAction(currentAgent);
		//prevOpponent = result.getOpponentAction();
		
		//if their action was defect, move on
		/*if(prevOpponent.compareTo(Action.DEFECT)==0) {
			
			//switch to other test of agent d
			currentAgent = Action.DEFECT;
			result = actionProcessor.submitAction(currentAgent);
			prevOpponent = result.getOpponentAction();
			
			//if their next action was cooperate, likely random
			//B defects then cooperates, not always cooperate, not always defect, not titfortat (it starts with cooperate)
			//Its probably Random, best way to attack random is with random
			
			if(prevOpponent.compareTo(Action.COOPERATE)==0) {
				actionProcessor.submitAction(Math.random() < 0.5 ? Action.COOPERATE : Action.DEFECT);
				
			} else if(prevOpponent.compareTo(Action.DEFECT)==0) {
				//always defect probably, should check third number to be sure, want points so using currentAgent b/c its still defect
				result = actionProcessor.submitAction(currentAgent);
				prevOpponent = result.getOpponentAction();
				if(prevOpponent.compareTo(Action.DEFECT)==0) {
					
					//then its always defect so always defect with it
					actionProcessor.submitAction(currentAgent);
				}
			}
		} else if(prevOpponent.compareTo(Action.COOPERATE)==0){
			//if first step is cooperate, could be always cooperate, random, or titfortat
			//switch to other test of agent d
			currentAgent = Action.DEFECT;
			result = actionProcessor.submitAction(currentAgent);
			prevOpponent = result.getOpponentAction();
			
			//if their next action was cooperate, could still be always cooperate, random, or titfortat
			if(prevOpponent.compareTo(Action.COOPERATE)==0) {
				//checking third number if same or changes, using currentAgent(still defect) b/c if they turn defect, still point
				result = actionProcessor.submitAction(currentAgent);
				prevOpponent = result.getOpponentAction();
				
				if(prevOpponent.compareTo(Action.COOPERATE)==0) {
					//has to be always cooperate so always defect
					actionProcessor.submitAction(currentAgent);
					
				} else if(prevOpponent.compareTo(Action.DEFECT)==0) {
					//if third action is defect, could be random or titfortat
					//plan for titfortat, will forever be defect unless I risk a cooperate and itll always be 3s instead of 1s
					currentAgent = Action.COOPERATE;
					actionProcessor.submitAction(currentAgent);
					
				}
				
			} else if(prevOpponent.compareTo(Action.DEFECT)==0) {
				//has to be random b/c titfortat would take my initial cooperate
				actionProcessor.submitAction(Math.random() < 0.5 ? Action.COOPERATE : Action.DEFECT);
			}
		}*/
	}
}
