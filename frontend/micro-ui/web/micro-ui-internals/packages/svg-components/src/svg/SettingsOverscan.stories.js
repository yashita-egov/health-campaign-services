import React from "react";
import { SettingsOverscan } from "./SettingsOverscan";

export default {
  tags: ['autodocs'],
  argTypes: {
    className: {
        options: ['custom-class'],
        control: { type: 'check' },
    }
  },
  title: "SettingsOverscan",
  component: SettingsOverscan,
};

export const Default = () => <SettingsOverscan />;
export const Fill = () => <SettingsOverscan fill="blue" />;
export const Size = () => <SettingsOverscan height="50" width="50" />;
export const CustomStyle = () => <SettingsOverscan style={{ border: "1px solid red" }} />;
export const CustomClassName = () => <SettingsOverscan className="custom-class" />;
