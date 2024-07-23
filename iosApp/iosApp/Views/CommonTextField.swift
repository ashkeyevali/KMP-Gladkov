//
//  CommonTextField.swift
//  iosApp
//
//  Created by Ashkeyev Ali on 18.07.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct CommonTextField: View {
    
    
    @State private var value: String = ""
    private let hint: String
    private let enabled: Bool
    private let isSecure: Bool
    let onChangeValue: (String) -> Void
    
    init(hint: String, enabled: Bool, isSecure: Bool, onChangeValue: @escaping (String) -> Void) {
        self.hint = hint
        self.enabled = enabled
        self.isSecure = isSecure
        self.onChangeValue = onChangeValue
    }
    
    var body: some View {
        ZStack(alignment: .leading) {
            RoundedRectangle(cornerRadius: 10)
                .foregroundColor(.secondaryBackground)
            
            if(value.isEmpty){
                Text(hint)
                    .foregroundColor(Color.textPrimary.opacity(0.5))
                    .padding(EdgeInsets(top: 0, leading: 20, bottom: 0, trailing: 20))
                    .font(.system(size: 16))
            }
            if isSecure{
                SecureField(value, text: $value)
                    .foregroundColor(.textPrimary)
                    .font(.system(size: 16))
                    .autocapitalization(/*@START_MENU_TOKEN@*/.none/*@END_MENU_TOKEN@*/)
                    .disabled(!enabled)
                    .disableAutocorrection(/*@START_MENU_TOKEN@*/false/*@END_MENU_TOKEN@*/)
                    .padding(EdgeInsets(top: 0, leading: 20, bottom: 0, trailing: 20))
                    .onChange(of: value){newValue in
                        onChangeValue(newValue)
                    }

            }
            else {
                TextField(value, text: $value)
                    .foregroundColor(.textPrimary)
                    .font(.system(size: 16))
                    .autocapitalization(/*@START_MENU_TOKEN@*/.none/*@END_MENU_TOKEN@*/)
                    .disabled(!enabled)
                    .disableAutocorrection(/*@START_MENU_TOKEN@*/false/*@END_MENU_TOKEN@*/)
                    .padding(EdgeInsets(top: 0, leading: 20, bottom: 0, trailing: 20))
                    .onChange(of: value){newValue in
                        onChangeValue(newValue)
                    }

            }
            
        }
        .frame(height:56)
        .padding(EdgeInsets(top: 0, leading: 24, bottom: 0, trailing: 24))
    }
}

#Preview {
    CommonTextField(hint: "Your login", enabled: true, isSecure: true, onChangeValue: {
        newValue in print(newValue)})
}
