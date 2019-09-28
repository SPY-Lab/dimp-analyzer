package interpreter;

import grammar.*;
import interpreter.Exception.EvaluationException;

import java.util.HashMap;

/**
 * Class representing abstract interpreter.
 * It is responsible of fixpoint computation of given CFG.
 */
public class AbstractInterpreter {

	private ControlFlowGraph cfg;
	private HashMap<Node, State> states;

	/**
	 * Abstract interpreter constructor.
	 * Set its CFG and initialize states.
	 *
	 * @param cfg cfg to be analyzed
	 * @param initialState initial states configuration
	 */
	public AbstractInterpreter(ControlFlowGraph cfg, State initialState) {
		System.out.println("FIRST STATE " + initialState);
		this.cfg = cfg;
		this.states = new HashMap<>();
		for (Node n : cfg.getNodes()){
			states.put(n, State.nullState());
		}
		states.put(cfg.getNodes().first(), initialState);
	}

	/**
	 * Abstract interpreter constructor.
	 * Set CFG to be analyzed.
	 *
	 * @param cfg cfg to be analyzed
	 */
	public AbstractInterpreter(ControlFlowGraph cfg){
		this(cfg, new State());
	}

	/**
	 * Compute fixpoint states of this cfg.
	 * Iterates on cfg nodes updating their state until it reaches a fixpoint.
	 */
	public void fixPoint(){
		boolean modified = true;
		int counter = 0;

		while (modified){
			System.out.println("\nITERAZIONE " + ++counter);
			modified = false;
			for ( Node n : cfg.getNodes()){
				// to the widening between its current state and the entering edges
				State actual = states.get(n);
				for ( Edge e : cfg.getEdgeTo(n)){
                    try {
                        actual = actual.leastUpperBound(AbstractSemantics.evaluate(e, states.get(e.getFrom())));
                    } catch (EvaluationException e1) {
                        e1.printStackTrace();
                    }
                }
				State newState = states.get(n).widening(actual);
				if ( !newState.equals(states.get(n)))
					modified = true;

				System.out.println(n + "- " + newState);
				states.put(n, newState);
			}
		}
	}

	/**
	 * Return state of last node of this cfg.
	 *
	 * @return state of last node of this cfg
	 */
	public State getLastState(){
		Node lastNode = cfg.getNodes().last();
		return states.get(lastNode);
	}

    public HashMap<Node, State> getStates() {
		return states;
    }
}
