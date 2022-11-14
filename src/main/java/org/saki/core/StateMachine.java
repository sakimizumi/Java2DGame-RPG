package org.saki.core;

import org.saki.core.stage.EmptyState;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class StateMachine {
    Map<String, IState> mStates = new HashMap<String, IState>();
    IState mCurrentState = new EmptyState();

    public void Update()
    {
        mCurrentState.Update();
    }

    public void Render(Graphics g)
    {
        mCurrentState.Render(g);
    }

    public void Change(String stateName)
    {
        mCurrentState.OnExit();
        mCurrentState = mStates.get(stateName);
        mCurrentState.OnEnter();
    }

    public void Add(String name, IState state)
    {
        mStates.put(name, state);
    }


}
