import React from "react";
import { SettingsVoice } from "./SettingsVoice";

export default {
  tags: ['autodocs'],
  argTypes: {
    className: {
        options: ['custom-class'],
        control: { type: 'check' },
    }
  },
  title: "SettingsVoice",
  component: SettingsVoice,
};

export const Default = () => <SettingsVoice />;
export const Fill = () => <SettingsVoice fill="blue" />;
export const Size = () => <SettingsVoice height="50" width="50" />;
export const CustomStyle = () => <SettingsVoice style={{ border: "1px solid red" }} />;
export const CustomClassName = () => <SettingsVoice className="custom-class" />;
