package com.bigkotik.calculator.events.queuehandler

import com.bigkotik.calculator.camera.CameraState

class OpenCameraEvent<T>(sequence: Array<T>, private val state: CameraState) :
    ButtonsSequenceEvent<T>(sequence) {
    override fun execute() {
        TODO("Not yet implemented")
    }
}