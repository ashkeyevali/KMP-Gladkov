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
    private let loginViewModel = LoginViewModel()

    var body: some View {
        ObservingView(statePublisher: statePublisher(loginViewModel.viewStates())){ viewState in
            LoginView(viewState: viewState){ event in
                loginViewModel.obtainEvent(viewEvent: event)
            }
        }
    }
}

struct LoginScreen_Previewa: PreviewProvider {
    static var previews: some View{
        LoginScreen()
    }
}
