package org.saki.core;

import java.awt.*;

public interface IState {
    void Update();
    void Render(Graphics g);
    void OnEnter();
    void OnExit();

}
