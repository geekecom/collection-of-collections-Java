package codeTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Implement an iterator that iterates all the elements of a collection of
 * collections
 * 
 */
public class CodeTestExerciseCollectionOfCollectionsIterator implements Iterator<Object> {

	private Collection<Collection<Object>> _collOfColl = null;
	private Integer currentPos;
	private List<Iterator<Object>> iterators;

	public List<Iterator<Object>> getIterators() {
		return iterators;
	}

	public void setIterators(List<Iterator<Object>> iterators) {
		this.iterators = iterators;
	}

	/**
	 * Constructor takes in the collection of collections that should be
	 * iterated
	 * 
	 * @param collofColl
	 *            collection of collections
	 */
	public CodeTestExerciseCollectionOfCollectionsIterator(Collection<Collection<Object>> collofColl) {
		_collOfColl = collofColl;
		this.currentPos = 0;
		this.iterators = new ArrayList<Iterator<Object>>();

		for (Collection<Object> c : _collOfColl) {
			iterators.add(c.iterator());
		}
	}

	public Collection<Collection<Object>> get_collOfColl() {
		return _collOfColl;
	}

	public void set_collOfColl(Collection<Collection<Object>> _collOfColl) {
		this._collOfColl = _collOfColl;
	}

	public Integer getCurrentPos() {
		return currentPos;
	}

	public void setCurrentPos(Integer currentPos) {
		this.currentPos = currentPos;
	}

	/**
	 * Returns true if the iteration has more elements
	 */
	public boolean hasNext() {
		for (Iterator<Object> i : getIterators()) {
			if (i.hasNext() == true)
				return true;
		}
		return false;
	}

	/**
	 * Returns the next element in the iteration
	 */
	public Object next() {
		if (!hasNext())
			throw new NoSuchElementException();

		Collection<Collection<Object>> collOfColl = get_collOfColl();
		Object next;

		Object[] collOfCollArray = collOfColl.toArray();

		if (getIterators().get(getCurrentPos()).hasNext())
			next = getIterators().get(getCurrentPos()).next();
		else {
			setCurrentPos(getCurrentPos() + 1);
			next = next();
		}
		return next;
	}

	/**
	 * Removes from the underlying collection the last element returned by the
	 * iterator For the code test, this does not need to be implemented.
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
