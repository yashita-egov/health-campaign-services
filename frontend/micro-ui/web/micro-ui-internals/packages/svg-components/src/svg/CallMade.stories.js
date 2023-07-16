import React from "react";
import { CallMade } from "./CallMade";

export default {
  tags: ['autodocs'],
  argTypes: {
    className: {
        options: ['custom-class'],
        control: { type: 'check' },
    }
  },
  title: "CallMade",
  component: CallMade,
};

export const Default = () => <CallMade />;
export const Fill = () => <CallMade fill="blue" />;
export const Size = () => <CallMade height="50" width="50" />;
export const CustomStyle = () => <CallMade style={{ border: "1px solid red" }} />;
export const CustomClassName = () => <CallMade className="custom-class" />;
