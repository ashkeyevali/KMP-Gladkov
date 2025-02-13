//
//  Flow+Publisher.swift
//  iosApp
//
//  Created by Ashkeyev Ali on 21.07.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SharedSDK
import Combine

func statePublisher<T>(_ flow: KviewmodelWrappedStateFlow<T>) -> AnyPublisher<T, Never> {
    return Deferred<Publishers.HandleEvents<PassthroughSubject<T, Never>>> {
        let subject = PassthroughSubject<T, Never>()
        let closeable = flow.watch { next in
            subject.send(next)
        }
        return subject.handleEvents(receiveCancel: {
            closeable.close()
        })
    }.eraseToAnyPublisher()
}

func sharedPublisher<T>(_ flow: KviewmodelWrappedSharedFlow<T>) -> AnyPublisher<T, Never> {
    return Deferred<Publishers.HandleEvents<PassthroughSubject<T, Never>>> {
        let subject = PassthroughSubject<T, Never>()
        let closeable = flow.watch { next in
            if let next=next {
                subject.send(next)
            }
        }
        return subject.handleEvents(receiveCancel: {
            closeable.close()
        })
    }.eraseToAnyPublisher()
}
