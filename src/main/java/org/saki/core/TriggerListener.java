package org.saki.core;

import org.saki.core.data.GameObject;

public interface TriggerListener {

    void triggerIn(GameObject object);

    void triggerOut(GameObject object);

    void onTrigger(GameObject object);
}
