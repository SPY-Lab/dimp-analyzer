package domains;

import it.univr.fsm.machine.Automaton;
import it.univr.fsm.machine.State;
import it.univr.fsm.machine.Transition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.TreeSet;

public class FA extends AbstractValue {

	public Automaton a;

	public FA(Automaton a) {
		this.a = a;
	}

	public FA(String s){
		if ( s.isEmpty()) {
			this.a = Automaton.makeEmptyString();
		}else {
			this.a = Automaton.makeAutomaton(s);
		}
	}

	public AbstractValue leastUpperBound(AbstractValue d) {
		if (d instanceof FA)
			return new FA(Automaton.union(a, ((FA) d).a));
		else
			return TopAV.getInstance();
	}

	public AbstractValue greatestLowerBound(AbstractValue d) {
		if (d instanceof FA)
			return new FA(Automaton.intersection(a, ((FA) d).a));
		else
			return BottomAV.getInstance();
	}

	public AbstractValue widening(AbstractValue d) {
		if (this.equals(d))
			return new FA(a);
		
		Automaton b = ((FA) this.leastUpperBound(d)).a.widening(FAWidening.getFaWideningValue());
		b.minimize();
		return new FA(b);
	}

	public FA substring(Interval init, Interval end) {
		Automaton result = Automaton.makeEmptyLanguage();

		if (init.isNegativeInfinite())
			init.setLow("0");

		if (end.isNegativeInfinite())
			end.setLow("0");

		//
		// First row
		//
		if (init.isFiniteConcrete()) {
			if (end.isFiniteConcrete()) {
				ArrayList<Long> initIntegers = init.getIntergers();
				ArrayList<Long> endIntegers = end.getIntergers();

				for (int i = 0; i < initIntegers.size(); i++)
					for (int j = 0; j < endIntegers.size(); j++)
						result = Automaton.union(result, Automaton.substring(this.a, initIntegers.get(i), endIntegers.get(j)));
				result.minimize();
				return new FA(result);
			} else if (end.isNegativeInfinite() && !end.isPositiveInfinite()) {
				return substring(init, new Interval("0", end.getHigh()));
			} else if (!end.isNegativeInfinite() && end.isPositiveInfinite()) {

				long i = Integer.parseInt(init.getLow());
				long j = Integer.parseInt(init.getHigh());
				long l = Integer.parseInt(end.getLow());


				// Table 1 case (first row, third column)
				if (i <= l && j <= l) {
					ArrayList<Long> initIntegers = init.getIntergers();

					for (int c = 0; c < initIntegers.size(); ++c)
						result = Automaton.union(result, Automaton.substringWithUnknownEndPoint(this.a, initIntegers.get(c), l));

					return new FA(result);

				}

				// Table 2 case (first row, third column)
				else if (l < i) {
					return (FA) (substring(new Interval(String.valueOf(l), String.valueOf(j)), new Interval(String.valueOf(i), String.valueOf(j)))).leastUpperBound(
							substring(new Interval(String.valueOf(i), String.valueOf(j)), new Interval(String.valueOf(j), "+Inf")));

				}

				// Table 3 (first row, third column)
				else if (i <= l && j > l) {
					FA first = substring(new Interval(String.valueOf(l), String.valueOf(j)), new Interval(String.valueOf(l), String.valueOf(j)));
					FA second = substring(new Interval(String.valueOf(i), String.valueOf(l)), new Interval(String.valueOf(l), "+Inf"));
					FA third = substring(new Interval(String.valueOf(l), String.valueOf(j)), new Interval(String.valueOf(j), "+Inf"));

					return (FA) first.leastUpperBound(second.leastUpperBound(third));

				}
			} else if (end.isNegativeInfinite() && end.isPositiveInfinite()) {
				return substring(init, new Interval("0", "+Inf"));
			}
		}

		//
		// Second row
		//
		else if (init.isNegativeInfinite() && !init.isPositiveInfinite()) {


			if (end.isFiniteConcrete()) {
				return substring(new Interval("0", init.getHigh()), end);
			} else if (end.isNegativeInfinite() && !end.isPositiveInfinite()) {
				return substring(new Interval("0", init.getHigh()), new Interval("0", end.getHigh()));
			} else if (!end.isNegativeInfinite() && end.isPositiveInfinite()) {
				return substring(new Interval("0", init.getHigh()), new Interval(end.getLow(), "+Inf"));
			} else if (end.isNegativeInfinite() && end.isPositiveInfinite()) {
				return substring(new Interval("0", "+Inf"), new Interval("0", "+Inf"));
			}

		}

		//
		// Third row
		//
		else if (!init.isNegativeInfinite() && init.isPositiveInfinite()) {

			if (end.isFiniteConcrete()) {

				long i = Integer.parseInt(init.getLow());
				long l = Integer.parseInt(end.getLow());
				long k = Integer.parseInt(end.getHigh());

				// Table 1 (third row, first column)
				if (i <= l) {
					FA first = substring(new Interval(String.valueOf(i), String.valueOf(k)), end);
					FA second = substring(end, new Interval(end.getLow(), "+Inf"));

					return (FA) first.leastUpperBound(second);
				}

				// Table 2 (third row, first column)
				else if (l < i && i <= k) {
					FA first = substring(new Interval(end.getLow(), end.getHigh()), new Interval(init.getLow(), end.getHigh()));
					FA second = substring(new Interval(end.getLow(), init.getLow()), new Interval(init.getLow(), "+Inf"));
					FA third = substring(new Interval(init.getLow(), end.getHigh()), new Interval(end.getHigh(), "+Inf"));

					return (FA) first.leastUpperBound(second.leastUpperBound(third));
				}

				// Table 3 (third row, first column)
				else if (i > k) {

					return substring(new Interval(end.getLow(), end.getHigh()), new Interval(init.getLow(), "+Inf"));
				}

			} else if (end.isNegativeInfinite() && !end.isPositiveInfinite()) {
				return substring(new Interval(init.getLow(), "+Inf"), new Interval("0", end.getHigh()));
			} else if (!end.isNegativeInfinite() && end.isPositiveInfinite()) {

				long i = Integer.parseInt(init.getLow());
				long l = Integer.parseInt(end.getLow());

				// Table 1 (third row, third column)
				if (i <= l) {
					FA first = substring(new Interval(init.getLow(), end.getLow()), new Interval(end.getLow(), "+Inf"));
					FA second = new FA(Automaton.factorsStartingAt(this.a, l));

					return (FA) first.leastUpperBound(second);
				}

				// Table 2 (third row, third column)
				else if (l < i) {
					return substring(new Interval(end.getLow(), "+Inf"), new Interval(init.getLow(), "+Inf"));
				}

				// Table 3 (third row, third column)
				else
					return substring(init, end);

			} else if (end.isNegativeInfinite() && end.isPositiveInfinite()) {
				return substring(new Interval(init.getLow(), "+Inf"), new Interval("0", "+Inf"));
			}

		}

		//
		// Fourth row
		//
		else if (init.isNegativeInfinite() && init.isPositiveInfinite()) {

			if (end.isFiniteConcrete()) {
				return substring(new Interval("0", "+Inf"), end);
			} else if (end.isNegativeInfinite() && !end.isPositiveInfinite()) {
				return substring(new Interval("0", "+Inf"), new Interval("0", end.getHigh()));
			} else if (!end.isNegativeInfinite() && end.isPositiveInfinite()) {
				return substring(new Interval("0", "+Inf"), new Interval(end.getLow(), "+Inf"));
			} else if (end.isNegativeInfinite() && end.isPositiveInfinite()) {
				return new FA(Automaton.factors(this.a));
			}
		}

		return null;
	}

	public FA charAt(Interval index) {
		Automaton result = Automaton.makeEmptyLanguage();        // Case 1
		if (index.isFiniteConcrete()) {
			ArrayList<Long> integers = index.getIntergers();
			for (int i = 0; i < integers.size(); ++i)
				result = Automaton.union(result, Automaton.charAt(this.a, integers.get(i)));
		}
		// Case 2
		else if (index.isNegativeInfinite() && !index.isPositiveInfinite() && Integer.parseInt(index.getHigh()) >= 0) {
			result = Automaton.union(charAt(new Interval("0", index.getHigh())).a, Automaton.makeEmptyString());
		}
		// Case 3
		else if (index.isNegativeInfinite() && !index.isPositiveInfinite() && Integer.parseInt(index.getHigh()) < 0) {
			result = Automaton.makeEmptyString();
		}
		// Case 4
		else if (!index.isNegativeInfinite() && index.isPositiveInfinite() && Integer.parseInt(index.getLow()) >= 0) {
			//            result = Automaton.intersection(Automaton.factorsStartingAt(this.a, Integer.parseInt(index.getLow())), Automaton.atMostLengthAutomaton(1));
			result = Automaton.union(chars(Automaton.suffixesAt(Integer.parseInt(index.getLow()), this.a)), Automaton.makeEmptyString());
		}
		// Case 5
		else {
			//            result = Automaton.intersection(Automaton.factors(this.a), Automaton.atMostLengthAutomaton(1));
			result = Automaton.union(chars(this.a), Automaton.makeEmptyString());
		} return new FA(result);
	}

	public Interval length() {
		if (this.a.hasCycle()) {
			TreeSet<Integer> lengths = new TreeSet<>();
			for (State f : this.a.getFinalStates())
				lengths.add(this.a.minimumDijkstra(f).size() - 1);
			return new Interval(String.valueOf(lengths.first()), "+Inf");
		} else {
			TreeSet<Integer> lengths = new TreeSet<>();
			for (State f : this.a.getFinalStates()) {
				lengths.add(this.a.maximumDijkstra(f).size() - 1);
				lengths.add(this.a.minimumDijkstra(f).size() - 1);
				System.out.println(lengths);
			}
			return new Interval(String.valueOf(lengths.first()), String.valueOf(lengths.last()));
		}
	}

	public static Automaton chars(Automaton a) {
		a.minimize();
		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();
		State q0 = new State("q0", true, false);
		State qf = new State("qf", false, true); states.add(q0);
		states.add(qf);
		for (Transition t : a.getDelta())
			delta.add(new Transition(q0, qf, t.getInput()));
		Automaton aut = new Automaton(delta, states);
		aut.minimize();
		return aut;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FA fsm = (FA) o;

		return a.equals(fsm.a);
	}


	@Override
	public int hashCode() {
		return Objects.hash(a);
	}

	@Override
	public String toString() {
		return a.toString();
	}

	public FA concat(FA second) {
		return new FA(Automaton.concat(this.a, second.a));
	}

	public Automaton stmSyn() {
		return a.stmSyn();
	}
}
