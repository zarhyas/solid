package com.ensa.projects.solid.InterfaceSegregation;

interface ICoffeeShop{
    //both
    void brewFilterCoffee();
}

interface ITraditional {
    void brewByEspressoMachine();
    void brewMachinePourOver();
}

interface IThirdWave {
    void brewByHandHeldEspressoMaker();
    void brewManualPourOver();
}
