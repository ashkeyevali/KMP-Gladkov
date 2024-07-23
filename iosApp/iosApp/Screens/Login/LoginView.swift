//
//  LoginView.swift
//  iosApp
//
//  Created by Ashkeyev Ali on 16.07.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct LoginView: View {
            
    let viewState: LoginViewState
    let eventHandler: (LoginEvent) -> Void

    var body: some View {
        VStack {
            VStack {
                Spacer().frame(height: 36)
                Text("Login Now")
                    .foregroundColor(.textPrimary)
                    .fontWeight(.bold)
                    .font(.system(size: 24))
                Text("Welcome back to PlayZone! Enter your email addres and your password to enjoy the latest features of PlayZone")
                    .foregroundColor(.textPrimary.opacity(0.5))
                    .fixedSize(horizontal: false, vertical: true)
                    .multilineTextAlignment(.center)
                    .padding(EdgeInsets(top: 16, leading: 30, bottom: 0, trailing: 30))
                
                Spacer().frame(height: 50)
                
                CommonTextField(hint: "Your login", enabled: !viewState.isSending, isSecure: false) {newValue in
                    eventHandler(.EmailChanged(email: newValue))
                    }
                Spacer().frame(height: 24)
                
                CommonTextField(hint: "Password", enabled: !viewState.isSending, isSecure: viewState.passwordHidden) {newValue in
                    eventHandler(.PasswordChanged(password: newValue))
                }
            }
            
            LoginActionView(
                viewState: viewState,
                onForgotClicked: {
                    eventHandler(.ForgotPasswordClicked())
                },
                
                onSubmitClicked: {
                    eventHandler(.LoginClicked())
                }).frame(height: 56)
            
            Spacer()
            HStack {
                Text("Don't have account?")
                    .foregroundColor(.textPrimary)
                    .opacity(0.5)
                Text("Create one")
                    .foregroundColor(.tint)
                    .fontWeight(/*@START_MENU_TOKEN@*/.bold/*@END_MENU_TOKEN@*/)
                    .onTapGesture {
                        eventHandler(.RegisterClicked())
                        
                    }
            }
        }

    }
}

struct LoginActionView: View {
    let viewState: LoginViewState
    let onForgotClicked: () -> Void
    let onSubmitClicked: () -> Void
    var body: some View {
        VStack {
            Spacer().frame(height: 30)
            HStack {
                Spacer()
                Text("Forgot password")
                    .foregroundColor(.tint)
                    .onTapGesture{onForgotClicked()}
                Spacer().frame(width: 30)

            }
            Spacer().frame(height: 30)
            
            ActionButton(title: "Login now", enabled: !viewState.isSending){
                onSubmitClicked()
            }


            
        }
        
    }
}

struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView( viewState: LoginViewState(email: "ashkeyevli", password: "password", isSending: false, passwordHidden: true), eventHandler: { event in }
        ).background(Color.backgroundPrimary)
    }
}
