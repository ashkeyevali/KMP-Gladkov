//
//  LoginScreen.swift
//  iosApp
//
//  Created by Ashkeyev Ali on 22.07.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct LoginScreen: View {
    @State private var isForgotPresented = false
    @State private var isRegistrationPresented = false
    @State private var isMainPresented = false

    
    private let loginViewModel = LoginViewModel()

    var body: some View {
        ObservingView(statePublisher: statePublisher(loginViewModel.viewStates())){ viewState in
            LoginView(viewState: viewState){ event in
                loginViewModel.obtainEvent(viewEvent: event)
            }
        }
        .sheet(isPresented: $isRegistrationPresented) { RegistrationScreen() }
        .sheet(isPresented: $isForgotPresented) {
//            ForgotPasswordScreen()
            TestComposeView{
                print("Test from outside")
            }//compose screen in native IOS navigation
        }

        .fullScreenCover(isPresented: $isMainPresented ) { MainView() }
        .onReceive(sharedPublisher(loginViewModel.viewActions())){action in
            switch(action) {
            case LoginAction.OpenForgotPasswordScreen():
                isForgotPresented = true
            case LoginAction.OpenRegisterScreen():
                isRegistrationPresented = true
            case LoginAction.OpenMainFlow():
                isMainPresented = true
            default:
                break
                

            }
        }
    }
}

struct LoginScreen_Previewa: PreviewProvider {
    static var previews: some View{
        LoginScreen()
    }
}
