// LAB 3 SESSION 11 | LAB05 SESSION 10.3: add throws PlayerException

package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public interface Playable {
    public void play() throws PlayerException;
}